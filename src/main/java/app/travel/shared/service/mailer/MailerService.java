package app.travel.shared.service.mailer;

import app.travel.domain.auth.payload.request.SignUpRequest;
import app.travel.shared.service.crypto.aes_gcm.ICryptoAesGcmService;
import app.travel.value.AppCoreValue;
import app.travel.value.MailValue;
import app.travel.value.PathValue;
import io.swagger.v3.core.util.Json;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.time.LocalDateTime;

@Slf4j(topic = "MAILER-SERVICE")
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MailerService implements IMailerService{

    JavaMailSender javaMailSender;

    PasswordEncoder passwordEncoder;

    SpringTemplateEngine templateEngine;

    AppCoreValue appCoreValue;

    PathValue pathValue;

    MailValue mailValue;

    ICryptoAesGcmService cryptoAesGcmService;

    @Override
    public void sendEmailConfirmSignUp(SignUpRequest request) throws Exception {

        log.info("Send email confirm signup {}", request.getEmail());

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        request.setConfirmPassword(passwordEncoder.encode(request.getConfirmPassword()));

        String signupIn4ToJson = Json.pretty(request);

        String signupIn4ToJsonEncode = cryptoAesGcmService.encode(signupIn4ToJson);

        Context context = new Context();

        String urlLinkFeConfirm = String.format("%s%s/%s", appCoreValue.getFrontendDomain(), pathValue.getFeSignupConfirmPath(), signupIn4ToJsonEncode);

        context.setVariable("linkFeSignUpConfirm", urlLinkFeConfirm);
        context.setVariable("year", LocalDateTime.now().getYear());

        String htmlContent = templateEngine.process(mailValue.getSignupConfirmTemplate(), context);

        String sendTo = request.getEmail();
        String subject = mailValue.getSignupConfirmSubject();

        sendToEmail(mailValue.getSendEmailFrom(), sendTo, subject, htmlContent);
    }

    @Override
    public void sendToEmail(String fromEmail, String toEmail, String subjectInEmail, String contentEmail) throws MessagingException {

        log.info("Send to email {}", toEmail);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, Boolean.TRUE);

        mimeMessageHelper.setFrom(fromEmail);
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setSubject(subjectInEmail);
        mimeMessageHelper.setText(contentEmail, Boolean.TRUE);

        javaMailSender.send(mimeMessage);
    }
}

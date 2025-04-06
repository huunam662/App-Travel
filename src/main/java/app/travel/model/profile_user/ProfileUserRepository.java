package app.travel.model.profile_user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileUserRepository extends JpaRepository<ProfileUserEntity, UUID> {
}

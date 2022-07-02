package study.datajpa.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class JpaBaseEntity {

    @Column(updatable = true)
    private LocalDateTime createdDate;
    private LocalDateTime udpatedDate;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        udpatedDate = now;
    }

    @PreUpdate
    public void preUpdate() {
        udpatedDate = LocalDateTime.now();
    }

}

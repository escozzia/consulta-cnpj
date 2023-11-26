package br.com.smart_br.consulta_cpnj.commons;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseEntity {
    /* SUMMARY
    * @createdAt Data de criação do registro;
    * @updatedAt Data da última alteração do registro;
    * @version Versão atual do registro;
    * @active Status do registro (ativo/inativo);
    * */

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "version")
    private long version;

    @Column(name = "active")
    private boolean active;
}

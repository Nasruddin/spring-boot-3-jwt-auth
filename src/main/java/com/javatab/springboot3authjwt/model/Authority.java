package com.javatab.springboot3authjwt.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authority_id")
    private Integer AuthorityId;

    @Enumerated(EnumType.STRING)
    private EAuthority authority;

    public Authority() {
    }

    public Authority(EAuthority authority) {
        this.authority = authority;
    }

    public Integer getAuthorityId() {
        return AuthorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        AuthorityId = authorityId;
    }

    @Override
    public String getAuthority() {
        return authority.name();
    }

    public void setAuthority(EAuthority authority) {
        this.authority = authority;
    }
}

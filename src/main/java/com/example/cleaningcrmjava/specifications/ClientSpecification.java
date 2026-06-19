package com.example.cleaningcrmjava.specifications;

import com.example.cleaningcrmjava.entities.Client;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.JoinType;

public class ClientSpecification {

    public static Specification<Client> hasFullName(String fullName) {
        return (root, query, cb) -> fullName == null ? null :
                cb.like(cb.lower(root.get("fullName")), "%" + fullName.toLowerCase() + "%");
    }

    public static Specification<Client> hasPhone(String phone) {
        return (root, query, cb) -> phone == null ? null :
                cb.like(cb.lower(root.get("phone")), "%" + phone.toLowerCase() + "%");
    }

    public static Specification<Client> hasEmail(String email) {
        return (root, query, cb) -> email == null ? null :
                cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%");
    }

    public static Specification<Client> hasCompanyName(String companyName) {
        return (root, query, cb) -> {
            if (companyName == null) return null;
            query.distinct(true);
            var join = root.join("companies", JoinType.LEFT);
            return cb.like(cb.lower(join.get("name")), "%" + companyName.toLowerCase() + "%");
        };
    }

    public static Specification<Client> hasAddress(String address) {
        return (root, query, cb) -> {
            if (address == null) return null;
            query.distinct(true);
            var join = root.join("addresses", JoinType.LEFT);
            return cb.like(cb.lower(join.get("line")), "%" + address.toLowerCase() + "%");
        };
    }
}
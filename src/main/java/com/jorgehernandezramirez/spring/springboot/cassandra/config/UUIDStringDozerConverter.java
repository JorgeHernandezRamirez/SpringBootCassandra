package com.jorgehernandezramirez.spring.springboot.cassandra.config;

import org.dozer.DozerConverter;

import java.util.UUID;

public class UUIDStringDozerConverter extends DozerConverter<UUID, String> {

    public UUIDStringDozerConverter(final Class<UUID> prototypeA, final Class<String> prototypeB) {
        super(prototypeA, prototypeB);
    }

    public UUIDStringDozerConverter() {
        super(UUID.class, String.class);
    }

    @Override
    public String convertTo(final UUID source, final String destination) {
        return source.toString();
    }

    @Override
    public UUID convertFrom(final String source, final UUID destination) {
        return UUID.fromString(source);
    }
}

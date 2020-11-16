package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Enter;
import hu.uni.eku.tzs.service.exceptions.GuestTooYoungException;

import java.util.Collection;
import java.util.Date;

public interface SaunaService {
    void Enter(String name, int age, Date Date) throws GuestTooYoungException;
    Collection<Enter> readAll();

}

package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

  public static Account getAccount
      (String raring, String type, String industry, String ownership, Boolean checkboxVip,
          Boolean checkboxSkills) {
    Faker faker = new Faker();
    return new Account(
        faker.company().name(),
        faker.phoneNumber().phoneNumber(),
        raring,
        faker.phoneNumber().phoneNumber(),
        faker.internet().domainName(),
        faker.number().digit(),
        faker.internet().emailAddress(),
        faker.idNumber().invalid(),
        faker.number().digit(),
        faker.number().digit(),
        faker.number().digit(),
        faker.address().streetAddress(),
        faker.address().streetAddress(),
        type,
        industry,
        ownership,
        checkboxVip,
        checkboxSkills
    );
  }
}
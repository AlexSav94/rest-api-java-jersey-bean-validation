package org.softspiders.jersey.validation;

import javax.validation.constraints.NotBlank;

@SecretMessage(password = "123")
public class Dto {
  @NotBlank(message = "not blank")
  private String input;
  private String secretInput;
  private String password;

  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
  }

  public String getSecretInput() {
    return secretInput;
  }

  public void setSecretInput(String secretInput) {
    this.secretInput = secretInput;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
package br.com.utils;

 import javax.validation.constraints.NotBlank;
 
 public class LoginRequest {
   @NotBlank
   private String login;
   @NotBlank
   private String senha;
   
   public String getLogin() {
     return this.login;
   }
   
   public void setLogin(String login) {
    this.login = login;
   }
   
   public String getSenha() {
     return this.senha;
   }
   
   public void setSenha(String senha) {
    this.senha = senha;
   }
 }



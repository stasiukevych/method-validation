package method.validation;

import jakarta.interceptor.Interceptors;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

public class User {

  private Role role;
  private String phone;
  private String username;

  @Interceptors(MethodInterceptor.class)
  @True
  public boolean updateRole(@NotNull Role role) {
    if (role == Role.ADMIN || role == null) {
      return false;
    }
    this.role = role;
    return true;
  }

  public Role getRole() {
    return role;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(role, user.role) && Objects.equals(phone, user.phone)
        && Objects.equals(username, user.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(role, phone, username);
  }

  @Override
  public String toString() {
    return "User{" +
        "role=" + role +
        ", phone='" + phone + '\'' +
        ", username='" + username + '\'' +
        '}';
  }
}
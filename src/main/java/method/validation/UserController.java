package method.validation;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.util.Arrays;

@Path("user")
public class UserController {

  @Inject
  private User user;

  @GET
  @Path("create/{username}/{role}/{phone}")
  public Response create(@PathParam("username") String username,
      @PathParam("phone") String phone, @PathParam("role") String role) {

    user.setUsername(username);
    user.setPhone(phone);
    boolean updateRole = user.updateRole(
        Arrays.stream(Role.values()).map(Enum::name).toList().contains(role) ? Role.valueOf(role)
            : null
    );

    if (updateRole) {
      System.out.println("Role updated on: " + role);
    }

    return Response.ok().entity("Created: " + user).build();
  }
}
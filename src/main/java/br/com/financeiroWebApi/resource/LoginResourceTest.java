package br.com.financeiroWebApi.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResourceTest {

//	private final  SecretKey CHAVE = Keys.hmacShaKeyFor(
//			"7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6"
//			.getBytes(StandardCharsets.UTF_8)); 
//	public Response post(Login login) {
//		try {
//			if(
//					login.getUsuarioEmal().equals("")
//					&&
//					login.getSenha().equals("")
//					) {
//				String jwtToken  = Jwts.builder()
//						.setSubject(login.getUsuarioEmal())
//						.setIssuer("localhost:8080")
//						.setIssuedAt(new Date())
//						.setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L)
//						.atZone(ZoneId.systemDefault())
//						.toInstant()))
//						.signWith(CHAVE, SignatureAlgorithm.RS256)
//						.compact();
//				
//				 return Response.status(Response.Status.OK).entity(jwtToken).build();
//			}else {
//				   return Response.status(Response.Status.UNAUTHORIZED)
//	                        .entity("Usuário e/ou senha inválidos").build();
//			}
//		} catch (Exception ex) {
//			return Response.status(
//                    Response.Status.INTERNAL_SERVER_ERROR
//                ).entity(ex.getMessage())
//                .build();
//		}
//	}
}

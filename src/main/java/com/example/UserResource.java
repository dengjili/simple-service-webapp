/**
 * <p>Title: UserResource.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: Ericsson</p>
 * @author dengjili
 * @date 2019年5月24日
 * @version 1.0
 */
package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * <p>Title: UserResource</p>
 * <p>Description: </p>
 * <p>Company: Ericsson</p> 
 * @author    dengjili
 * @date      2019年5月24日 下午10:04:04
 */
@Path("/users/{username}")
public class UserResource {
 
    @GET
    @Produces("text/xml")
    public String getUser(@PathParam("username") String userName) {
        return "hello";
    }
}

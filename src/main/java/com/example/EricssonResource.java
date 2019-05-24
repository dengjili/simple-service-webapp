/**
 * <p>Title: EricssonResource.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: Ericsson</p>
 * @author dengjili
 * @date 2019年5月24日
 * @version 1.0
 */
package com.example;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>Title: EricssonResource</p>
 * <p>Description: </p>
 * <p>Company: Ericsson</p> 
 * @author    dengjili
 * @date      2019年5月24日 下午5:43:21
 */

@Path("test")
public class EricssonResource {
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	@Path("hello")
    public String hello() {
        return "hello";
    }
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	@Path("param/{username}")
    public String param(@PathParam("username") String name) {
        return name;
    }
	
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	@Path("param2")
    public String param2(@QueryParam("username") String name, @DefaultValue("true") @QueryParam("max-m") String hasMax) {
		System.out.println(hasMax);
        return name;
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("doGetAsXmlOrJson")
	public String doGetAsXmlOrJson() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "asfd");
		jsonObject.put("name", "张仨");
		return jsonObject.toJSONString();
	}
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Path("post")
	public void post(@FormParam("name") String name) {
	    System.out.println(name);
	}
	
	@GET
	@Path("complex/{xxxx}")
	public String complex(@Context UriInfo ui, @Context HttpHeaders hh) {
	    MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
	    System.out.println(queryParams);
	    MultivaluedMap<String, String> pathParams = ui.getPathParameters();
	    System.out.println(pathParams);
	    
	    MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
	    System.out.println(headerParams);
	    Map<String, Cookie> pathParams2 = hh.getCookies();
	    System.out.println(pathParams2);
		return "complex";
	}
	
	@POST
	@Path("complex/yyyy")
	public String complex2(@Context UriInfo ui, @Context HttpHeaders hh) {
	    MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
	    System.out.println(queryParams);
	    MultivaluedMap<String, String> pathParams = ui.getPathParameters();
	    System.out.println(pathParams);
	    
	    MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
	    System.out.println(headerParams);
	    Map<String, Cookie> pathParams2 = hh.getCookies();
	    System.out.println(pathParams2);
		return "complex2";
	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Path("postParam")
	public void postParam(MultivaluedMap<String, String> formParams) {
		for (Entry<String, List<String>> entry : formParams.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();
			System.out.println(key + " : " + value.get(0));
		}
	}
}

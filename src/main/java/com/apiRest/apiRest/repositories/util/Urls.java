package com.apiRest.apiRest.repositories.util;

import java.io.Serializable;

public class Urls implements Serializable {
    //public static final String ROOT = "/";
	public static final String API = "/api";

    public static class alumno {
		public static final String BASE = API + "/alumno";
	}
	public static class usuario {
		public static final String BASE = API + "/usuario";
	}
	public static class producto {
		public static final String BASE = API + "/producto";
	}
    public static class auth {
		public static final String BASE = API + "/auth";
	}
}

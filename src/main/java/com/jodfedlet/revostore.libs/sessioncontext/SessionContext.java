package com.jodfedlet.revostore.sessioncontext;

public class SessionContext {

  private static final ThreadLocal<SessionContextModel> context = new ThreadLocal<>();

  public static SessionContextModel get() {
    return context.get();
  }

  public static void set(SessionContextModel session) {
    context.set(session);
  }

  public static void clear() {
    context.remove();
  }
}

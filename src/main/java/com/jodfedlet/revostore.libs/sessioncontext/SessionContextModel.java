package com.jodfedlet.revostore.sessioncontext;

public record SessionContextModel(
    String userId,
    String email,
    String accessToken
) {

}

package kz.iitu.itse1903.sugurali.security;

public enum UserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    BOOK_READ("book:read"),
    BOOK_WRITE("book:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

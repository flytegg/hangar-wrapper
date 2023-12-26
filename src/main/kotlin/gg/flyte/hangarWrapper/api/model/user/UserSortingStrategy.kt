package gg.flyte.hangarWrapper.api.model.user

enum class UserSortingStrategy(val paramName : String) {
    NAME("name"),
    CREATED_AT("createdAt"),
    PROJECT_COUNT("projectCount"),
    LOCKED("locked"),
    ORG("org"),
    ROLES("roles"),
}
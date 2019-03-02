package sdi.training.sql;

public class CatPassportSQL {
    public static String GET_ALL_CAT_PASSPORTS_SQL = "SELECT passport_id," +
            " passport_content FROM cat_passport";

    public static String GET_ALL_CAT_PASSPORTS_BY_ID = "SELECT passport_id," +
            " passport_content FROM cat_passport WHERE passport_id = ?";

    public static String DELETE_CAT_PASSPORT_BY_ID = "DELETE FROM cat_passport " +
            "WHERE passport_id = ?";

    public static String INSERT_INTO_CAT_PASSPORT = "INSERT into cat_passport " +
            "(passport_content)" +
            "VALUES (?)";
}

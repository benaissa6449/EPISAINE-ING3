package fr.upec.sirius.episaine.episaine_send_notification.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.upec.sirius.episaine.episaine_send_notification.dto.RecipeDto;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RecipeReadRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<RecipeDto> findByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return List.of();
        }

        String sql = """
                SELECT m.*
                FROM gold.meals m
                WHERE m.id IN (:ids)
                """;

        return jdbcTemplate.query(sql, new MapSqlParameterSource("ids", ids), new RecipeDtoRowMapper());
    }

    private static final class RecipeDtoRowMapper implements RowMapper<RecipeDto> {
        @Override
        public RecipeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Map<String, Object> row = new HashMap<>();
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                row.put(rs.getMetaData().getColumnLabel(i).toLowerCase(Locale.ROOT), rs.getObject(i));
            }

            return RecipeDto.builder()
                    .id(asInteger(first(row, "id")))
                    .ingredients(asString(first(row, "ingredients")))
                    .instructions(asString(first(row, "strinstructions", "str_instructions", "instructions")))
                    .calories(asInteger(first(row, "calories")))
                    .mealName(asString(first(row, "strmeal", "str_meal", "meal_name")))
                    .category(asString(first(row, "strcategory", "str_category", "category")))
                    .areaId(asString(first(row, "area_id", "areaid")))
                    .build();
        }

        private static Object first(Map<String, Object> row, String... keys) {
            for (String key : keys) {
                if (row.containsKey(key)) {
                    return row.get(key);
                }
            }
            return null;
        }

        private static String asString(Object value) {
            return value == null ? null : String.valueOf(value);
        }

        private static Integer asInteger(Object value) {
            if (value == null) {
                return null;
            }
            if (value instanceof Integer i) {
                return i;
            }
            if (value instanceof Number n) {
                return n.intValue();
            }
            return Integer.parseInt(String.valueOf(value));
        }
    }
}

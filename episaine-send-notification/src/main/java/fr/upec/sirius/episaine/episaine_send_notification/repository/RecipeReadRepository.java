package fr.upec.sirius.episaine.episaine_send_notification.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
                SELECT m.id,
                       m.ingredients,
                       CAST(m."strInstructions" AS text) AS instructions,
                       m.calories,
                       CAST(m."strMeal" AS text) AS meal_name,
                       CAST(m."strCategory" AS text) AS category,
                       CAST(m.area_id AS text) AS area_id
                FROM gold.meals m
                WHERE m.id IN (:ids)
                """;

        return jdbcTemplate.query(sql, new MapSqlParameterSource("ids", ids), new RecipeDtoRowMapper());
    }

    private static final class RecipeDtoRowMapper implements RowMapper<RecipeDto> {
        @Override
        public RecipeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            return RecipeDto.builder()
                    .id((Integer) rs.getObject("id"))
                    .ingredients(rs.getString("ingredients"))
                    .instructions(rs.getString("instructions"))
                    .calories((Integer) rs.getObject("calories"))
                    .mealName(rs.getString("meal_name"))
                    .category(rs.getString("category"))
                    .areaId(rs.getString("area_id"))
                    .build();
        }
    }
}

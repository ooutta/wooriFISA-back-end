package model.cafe.bar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 바리스타가 이용할 수 있는 클래스
 * 다른 클래스에서는 접근 불가
 * Field Summary
 * 2. 음료 이름 - name
 * 3. 레시피(Recipe) recipe
 */
@Builder
@ToString
public class Drink {
    String name;
    Recipe recipe;
}

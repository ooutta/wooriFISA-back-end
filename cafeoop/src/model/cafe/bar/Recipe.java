package model.cafe.bar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * 바리스타가 이용하는 클래스
 *
 * Field Summary
 * 1. 음료를 제조하기 위한 재료 리스트 - List<String> materials
 * 2. 제조법 - String description
 */

@AllArgsConstructor
@Getter
@Builder
@ToString
public class Recipe {
    private String name;
    private List<String> materials;
    private String decription;
}

package car.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    public static final MoveChance MOVABLE_CHANCE = () -> true;
    @Test
    @DisplayName("가장 멀리 이동한 자동차의 위치를 찾는 메서트 테스트")
    void 가장_먼_자동차_위치를_찾는다() {
        Car car1 = new Car("땡칠", 0);
        Car car2 = new Car("물떡", 2);
        Car car3 = new Car("루쿠", 1);
        Game game = new Game(List.of(car1, car2, car3), MOVABLE_CHANCE);
        assertThat(game.findMaxPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차에게 이동 기회를 주는 테스트")
    void 자동차에게_이동_기회를_준다() {
        Car car = new Car("물떡");
        Game game = new Game(List.of(car), MOVABLE_CHANCE);
        game.playOnce();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}

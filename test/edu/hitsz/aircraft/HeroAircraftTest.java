package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroAircraftTest {

    private HeroAircraft heroAircraft;

    @BeforeAll
    static void beforeAll(){
        System.out.println("**--- Executed once before all test methods in this class ---**");
    }

    @BeforeEach
    void setUp(){
        heroAircraft = HeroAircraft.getInstance();
    }

    @AfterEach
    void tearDown() {
        heroAircraft = null;
    }

    @ParameterizedTest
    @DisplayName("Test getShootNum Method")
    @CsvSource({"1", "2", "3"})
    void getShootNum(int i){
        heroAircraft.setShootNum(i);
        int j = heroAircraft.getShootNum();
        assertEquals(i,j);
    }

    @ParameterizedTest
    @DisplayName("Test increaseHp Method")
    @CsvSource({"20,30,1000", "40,30,990"})
    void increaseHp(int decrease_hp,int increase_hp,int hp) {
        heroAircraft.decreaseHp(decrease_hp);
        heroAircraft.increaseHp(increase_hp);
        assertEquals(hp,heroAircraft.getHp());
    }

    @ParameterizedTest
    @DisplayName("Test shoot Method")
    @CsvSource({"1", "2", "3"})
    void shoot(int i) {
        heroAircraft.setShootNum(i);
        List<BaseBullet> res = heroAircraft.shoot();
        assertEquals(i, res.size());
    }
}
package com.gamemall.gamemall.repositoy;

import com.gamemall.gamemall.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>, JpaSpecificationExecutor<Game> {

//    @Query(value = "select new map(t1,t2) from  Game t1 left  join GameIndex t2 on t1.id=t2.gameId where t2.showType =:show_type")
//    List<Map<String, Object>> findGameAndGameIndexByHQL(@Param("show_type") Long show_type);

    @Query(value = "select new map(t1,t2) from  Game t1 left  join GameImage t2 on t1.id=t2.gameId where t1.id =:id")
    List<Map<String, Object>> findGameAndGameImageByHQL(@Param("id") Long id);

    @Query(value = "select new map(t1,t2) from  Game t1 left  join GameImage t2 on t1.id=t2.gameId where t1.recommend =:recommend")
    List<Map<String, Object>> findGamesByRecommend(@Param("recommend") String recommend);

    @Query(value = "select new map(t1,t2) from  Game t1 left  join GameImage t2 on t1.id=t2.gameId where t1.sellwell =:sellwell")
    List<Map<String, Object>> findGamesBySellwell(@Param("sellwell") String sellwell);

    @Query(value = "select new map(t1,t2) from  Game t1 left  join GameImage t2 on t1.id=t2.gameId where t1.prepurchase =:prepurchase")
    List<Map<String, Object>> findGamesByPrepurchase(@Param("prepurchase") String prepurchase);

    @Query(value = "select new map(t1,t2) from  Game t1 left  join GameImage t2 on t1.id=t2.gameId where t1.masterpiece =:masterpiece")
    List<Map<String, Object>> findGamesByMasterpiece(@Param("masterpiece") String masterpiece);

    @Query(value = "select new map(t1,t2) from  Game t1 left  join GameImage t2 on t1.id=t2.gameId where t1.single =:single")
    List<Map<String, Object>> findGamesBySingle(@Param("single") String single);

    @Query(value = "select new map(t1,t2) from  Game t1 left  join GameImage t2 on t1.id=t2.gameId where t1.gameName =:gameName")
    List<Map<String, Object>> findGameByName(@Param("gameName") String gameName);

    Game findById(Long id);

}

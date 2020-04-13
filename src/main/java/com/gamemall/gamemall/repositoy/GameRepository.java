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

    @Query(value = "select new map(t1,t2) from  Game t1 left  join GameIndex t2 on t1.id=t2.gameId where t2.showType =:show_type")
    List<Map<String, Object>> findGameAndGameIndexByHQL(@Param("show_type") Long show_type);

//    @Query(value = "select new map(t1,t2) from  Game t1 left  join GameImage t2 on t1.id=t2.gameId where t2.showType =:id")
//    List<Map<String, Object>> findGameAndGameImageByHQL(@Param("show_type") Long id);
}

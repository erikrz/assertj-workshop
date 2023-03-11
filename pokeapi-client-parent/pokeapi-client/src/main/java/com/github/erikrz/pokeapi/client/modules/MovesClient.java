package com.github.erikrz.pokeapi.client.modules;


import com.github.erikrz.pokeapi.dto.NamedApiResourceList;
import com.github.erikrz.pokeapi.dto.move.Move;
import com.github.erikrz.pokeapi.dto.moveailment.MoveAilment;
import com.github.erikrz.pokeapi.dto.movebattlestyle.MoveBattleStyle;
import com.github.erikrz.pokeapi.dto.movecategory.MoveCategory;
import com.github.erikrz.pokeapi.dto.movedamageclass.MoveDamageClass;
import com.github.erikrz.pokeapi.dto.movelearnmethod.MoveLearnMethod;
import com.github.erikrz.pokeapi.dto.movetarget.MoveTarget;

import feign.Param;
import feign.RequestLine;

public interface MovesClient {

    @RequestLine("GET /move?offset={offset}&limit={offset}")
    NamedApiResourceList<Move> getMoves(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /move/{id}")
    Move getMove(@Param("id") Integer id);

    @RequestLine("GET /move/{name}")
    Move getMove(@Param("name") String name);


    @RequestLine("GET /move-ailment?offset={offset}&limit={offset}")
    NamedApiResourceList<MoveAilment> getMoveAilments(@Param("offset") Integer offset,
                                                      @Param("limit") Integer limit);

    @RequestLine("GET /move-ailment/{id}")
    MoveAilment getMoveAilment(@Param("id") Integer id);

    @RequestLine("GET /move-ailment/{name}")
    MoveAilment getMoveAilment(@Param("name") String name);


    @RequestLine("GET /move-battle-style?offset={offset}&limit={offset}")
    NamedApiResourceList<MoveBattleStyle> getMoveBattleStyles(@Param("offset") Integer offset,
                                                              @Param("limit") Integer limit);

    @RequestLine("GET /move-battle-style/{id}")
    MoveBattleStyle getMoveBattleStyle(@Param("id") Integer id);

    @RequestLine("GET /move-battle-style/{name}")
    MoveBattleStyle getMoveBattleStyle(@Param("name") String name);


    @RequestLine("GET /move-category?offset={offset}&limit={offset}")
    NamedApiResourceList<MoveCategory> getMoveCategories(@Param("offset") Integer offset,
                                                         @Param("limit") Integer limit);

    @RequestLine("GET /move-category/{id}")
    MoveCategory getMoveCategory(@Param("id") Integer id);

    @RequestLine("GET /move-category/{name}")
    MoveCategory getMoveCategory(@Param("name") String name);


    @RequestLine("GET /move-damage-class?offset={offset}&limit={offset}")
    NamedApiResourceList<MoveDamageClass> getMoveDamageClasses(@Param("offset") Integer offset,
                                                               @Param("limit") Integer limit);

    @RequestLine("GET /move-damage-class/{id}")
    MoveDamageClass getMoveDamageClass(@Param("id") Integer id);

    @RequestLine("GET /move-damage-class/{name}")
    MoveDamageClass getMoveDamageClass(@Param("name") String name);


    @RequestLine("GET /move-learn-method?offset={offset}&limit={offset}")
    NamedApiResourceList<MoveLearnMethod> getMoveLearnMethods(@Param("offset") Integer offset,
                                                              @Param("limit") Integer limit);

    @RequestLine("GET /move-learn-method/{id}")
    MoveLearnMethod getMoveLearnMethod(@Param("id") Integer id);

    @RequestLine("GET /move-learn-method/{name}")
    MoveLearnMethod getMoveLearnMethod(@Param("name") String name);


    @RequestLine("GET /move-target?offset={offset}&limit={offset}")
    NamedApiResourceList<MoveTarget> getMoveTargets(@Param("offset") Integer offset,
                                                    @Param("limit") Integer limit);

    @RequestLine("GET /move-target/{id}")
    MoveTarget getMoveTarget(@Param("id") Integer id);

    @RequestLine("GET /move-target/{name}")
    MoveTarget getMoveTarget(@Param("name") String name);
}

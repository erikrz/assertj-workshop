package com.github.erikrz.pokeapi.client.modules;

import com.github.erikrz.pokeapi.dto.NamedApiResourceList;
import com.github.erikrz.pokeapi.dto.item.Item;
import com.github.erikrz.pokeapi.dto.itemattribute.ItemAttribute;
import com.github.erikrz.pokeapi.dto.itemcategory.ItemCategory;
import com.github.erikrz.pokeapi.dto.itemflingeffect.ItemFlingEffect;
import com.github.erikrz.pokeapi.dto.itempocket.ItemPocket;

import feign.Param;
import feign.RequestLine;

public interface ItemsClient {

    @RequestLine("GET /item?offset={offset}&limit={offset}")
    NamedApiResourceList<Item> getItems(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /item/{id}")
    Item getItem(@Param("id") Integer id);

    @RequestLine("GET /item/{name}")
    Item getItem(@Param("name") String name);


    @RequestLine("GET /item-attribute?offset={offset}&limit={offset}")
    NamedApiResourceList<ItemAttribute> getItemAttributes(@Param("offset") Integer offset,
                                                          @Param("limit") Integer limit);

    @RequestLine("GET /item-attribute/{id}")
    ItemAttribute getItemAttribute(@Param("id") Integer id);

    @RequestLine("GET /item-attribute/{name}")
    ItemAttribute getItemAttribute(@Param("name") String name);


    @RequestLine("GET /item-category?offset={offset}&limit={offset}")
    NamedApiResourceList<ItemCategory> getItemCategories(@Param("offset") Integer offset,
                                                         @Param("limit") Integer limit);

    @RequestLine("GET /item-category/{id}")
    ItemCategory getItemCategory(@Param("id") Integer id);

    @RequestLine("GET /item-category/{name}")
    ItemCategory getItemCategory(@Param("name") String name);


    @RequestLine("GET /item-fling-effect?offset={offset}&limit={offset}")
    NamedApiResourceList<ItemFlingEffect> getItemFlingEffects(@Param("offset") Integer offset,
                                                              @Param("limit") Integer limit);

    @RequestLine("GET /item-fling-effect/{id}")
    ItemFlingEffect getItemFlingEffect(@Param("id") Integer id);

    @RequestLine("GET /item-fling-effect/{name}")
    ItemFlingEffect getItemFlingEffect(@Param("name") String name);


    @RequestLine("GET /item-pocket?offset={offset}&limit={offset}")
    NamedApiResourceList<ItemPocket> getItemPockets(@Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /item-pocket/{id}")
    ItemPocket getItemPocket(@Param("id") Integer id);

    @RequestLine("GET /item-pocket/{name}")
    ItemPocket getItemPocket(@Param("name") String name);
}

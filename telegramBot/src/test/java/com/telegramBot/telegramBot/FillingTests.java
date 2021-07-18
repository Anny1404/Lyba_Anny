package com.telegramBot.telegramBot;



import com.telegramBot.telegramBot.Entity.*;
import com.telegramBot.telegramBot.Repository.CategoryRepository;
import com.telegramBot.telegramBot.Repository.ClientRepository;
import com.telegramBot.telegramBot.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FillingTests {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;


    private void CreateAndSaveClientInBD(Long externalId,  String fullName, String phoneNumber,String address){
        Client client = new Client();
        client.setExternal_id(externalId);
        client.setFull_name(fullName);
        client.setPhone_number(phoneNumber);
        client.setAddress(address);
        clientRepository.save(client);
    }

    private Category CreateAndSaveCategoryInBD(String name, Long parent){
        Category category = new Category();
        category.setName(name);
        category.setParent(parent);
        categoryRepository.save(category);
        return category;
    }

    private void CreateAndSaveProductInBD(String name, String description, Double price, Category category){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setId_category(category);
        productRepository.save(product);
    }


    @Test
    public void createTwoClients(){
        CreateAndSaveClientInBD(1L,"fullName1","+78901234567","address1");
        CreateAndSaveClientInBD(2L,"fullName2","+76543210987","address2");
    }

    @Test
    public void createProductsAndCategories(){

        Category pizza = CreateAndSaveCategoryInBD("Пицца",0L);
        Category rolls = CreateAndSaveCategoryInBD("Роллы",0L);
        Category burgers = CreateAndSaveCategoryInBD("Бургеры",0L);
        Category drinks = CreateAndSaveCategoryInBD("Напитки",0L);

        Category classicRolls = CreateAndSaveCategoryInBD("Классические роллы",rolls.getId());
        Category bakedRolls = CreateAndSaveCategoryInBD("Запеченные роллы",rolls.getId());
        Category sweetRolls = CreateAndSaveCategoryInBD("Сладкие роллы",rolls.getId());
        Category setsRolls = CreateAndSaveCategoryInBD("Наборы",rolls.getId());

        Category classicBurgers = CreateAndSaveCategoryInBD("Классические бургеры",burgers.getId());
        Category spicyBurgers = CreateAndSaveCategoryInBD("Острые бургеры",burgers.getId());

        Category carbonatedDrinks = CreateAndSaveCategoryInBD("Газированные напитки",drinks.getId());
        Category energyDrinks = CreateAndSaveCategoryInBD("Энергетические напитки",drinks.getId());
        Category juices = CreateAndSaveCategoryInBD("Соки",drinks.getId());
        Category otherDrinks = CreateAndSaveCategoryInBD("Другие напитки",drinks.getId());

        CreateAndSaveProductInBD("Пицца 1","Время приготовления 20 минут",100.00,pizza);
        CreateAndSaveProductInBD("Пицца 2","Время приготовления 30 минут",100.00,pizza);
        CreateAndSaveProductInBD("Пицца 3","Время приготовления 40 минут",100.00,pizza);

        CreateAndSaveProductInBD("Классический ролл 1","Классические роллы",200.00,classicRolls);
        CreateAndSaveProductInBD("Классический ролл 2","Классические роллы ",200.00,classicRolls);
        CreateAndSaveProductInBD("Классический ролл 3","Классические роллы",200.00,classicRolls);

        CreateAndSaveProductInBD("Запеченный ролл 1","Запеченные роллы",300.00,bakedRolls);
        CreateAndSaveProductInBD("Запеченный ролл 2","Запеченные роллы",300.00,bakedRolls);
        CreateAndSaveProductInBD("Запеченный ролл 3","Запеченные роллы ",300.00,bakedRolls);

        CreateAndSaveProductInBD("Сладкий ролл 1","Сладкая парочка",400.00,sweetRolls);
        CreateAndSaveProductInBD("Сладкий ролл 2","Моя девочка",400.00,sweetRolls);
        CreateAndSaveProductInBD("Сладкий ролл 3" ,"Любимка",400.00,sweetRolls);

        CreateAndSaveProductInBD("Набор роллов 1","Гурман ",500.00,setsRolls);
        CreateAndSaveProductInBD("Набор роллов 2","Романтика",500.00,setsRolls);
        CreateAndSaveProductInBD("Набор роллов 3","Хитовый",500.00,setsRolls);

        CreateAndSaveProductInBD("Классический бургер 1","Классический бургер с курицей",600.00,classicBurgers);
        CreateAndSaveProductInBD("Классический бургер 2","Классический бургер с рыбой",600.00,classicBurgers);
        CreateAndSaveProductInBD("Классический бургер 3","Классический бургер Чизбургер",600.00,classicBurgers);

        CreateAndSaveProductInBD("Острый бургер 1","Биг тейсти",700.00,spicyBurgers);
        CreateAndSaveProductInBD("Острый бургер 2","Жгучий чизбургер",700.00,spicyBurgers);
        CreateAndSaveProductInBD("Острый бургер 3","Фишбургер с огоньком",700.00,spicyBurgers);

        CreateAndSaveProductInBD("Газированный напиток 1","Лимонад",800.00,carbonatedDrinks);
        CreateAndSaveProductInBD("Газированный напиток 2","Фанта",800.00,carbonatedDrinks);
        CreateAndSaveProductInBD("Газированный напиток 3","Спрайт",800.00,carbonatedDrinks);

        CreateAndSaveProductInBD("Энергетический напитко 1","RedBull",900.00,energyDrinks);
        CreateAndSaveProductInBD("Энергетический напитко 2" ,"Gorilla",900.00,energyDrinks);
        CreateAndSaveProductInBD("Энергетический напитко 3","Flash",900.00,energyDrinks);

        CreateAndSaveProductInBD("Сок 1","Любимый",1000.00,juices);
        CreateAndSaveProductInBD("Сок 2","Сочная долина",1000.00,juices);
        CreateAndSaveProductInBD("Сок 3","Фруто-няня",1000.00,juices);

        CreateAndSaveProductInBD("Другой напиток 1","Дайкири",1100.00,otherDrinks);
        CreateAndSaveProductInBD("Другой напиток 2","Мохито",1100.00,otherDrinks);
        CreateAndSaveProductInBD("Другой напиток 3","Абсент",1100.00,otherDrinks);

    }



}

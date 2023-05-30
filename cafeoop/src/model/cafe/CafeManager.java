package model.cafe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import model.cafe.bar.Barista;
import model.cafe.bar.Recipe;
import model.cafe.hall.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class CafeManager {

    private List<Staff> staffs;
    private List<Barista> baristas;
    private Menu menu;

    private List<Recipe> recipes = new ArrayList();

    private List<Customer> customers = new ArrayList();

    private static CafeManager cafeManager = new CafeManager();

    private CafeManager() {
        // 카페 오픈 시 기본 세팅
        // 주문 담당자(Casher, Barista)들은 하나의 주문에 있어서 담당이 바뀌면 안됨
        
        // Casher 리스트
        Staff kang = new Staff();
        Staff kim = new Staff();
        Staff koo = new Staff();

        Staff[] staffList = {kang, kim, koo};
        List<Staff> staffs = new ArrayList(Arrays.asList(staffList));
        this.staffs = staffs;

        // Barista 리스트
        Barista son = new Barista();
        Barista seo = new Barista();

        Barista[] baristaList = {son, seo};
        List<Barista> baristas = new ArrayList(Arrays.asList(baristaList));
        this.baristas = baristas;

        // 메뉴판 세팅
        MenuItem item1 = new MenuItem("아이스 아메리카노", 2000, 1, 99);
        MenuItem item2 = new MenuItem("헤이즐 아메리카노 오늘의 원두", 3000, 2, 60);
        MenuItem item3 = new MenuItem("페퍼민트", 4000, 10, 50);
        MenuItem item4 = new MenuItem("사과유자차", 4500, 10, 65);

        MenuItem[] menuItems = {item1, item2, item3, item4};
        List<MenuItem> menuList = new ArrayList(Arrays.asList(menuItems));

        Menu menu = new Menu("카페 메뉴판", menuList);
        this.menu = menu;

        List<String> iceAmericano = new ArrayList();
        iceAmericano.add("원두");
        iceAmericano.add("물");
        recipes.add(new Recipe("아이스 아메리카노", iceAmericano, "스피드가 생명"));

        List<String> hazel = new ArrayList();
        hazel.add("헤이즐 원두");
        hazel.add("물");
        recipes.add(new Recipe("헤이즐 아메리카노",hazel, "향이 생명"));

        List<String> pepperMint = new ArrayList();
        pepperMint.add("페퍼민트 잎");
        pepperMint.add("물");
        recipes.add(new Recipe("페퍼민트", pepperMint, "잎 원산지가 생명"));

        List<String> appleCitron = new ArrayList();
        appleCitron.add("사과");
        appleCitron.add("유자");
        appleCitron.add("물");
        recipes.add(new Recipe("사과유자차", appleCitron, "사과 싱싱함이 생명"));

        // 고객 정보 세팅
        HashMap<String, Integer> orderHistory = new HashMap();
        orderHistory.put("페퍼민트", 5);
        orderHistory.put("얼그레이", 2);
        orderHistory.put("헤이즐 아메리카노", 5);
        CustomerInfo infoOfYoo = new CustomerInfo(orderHistory, 12);
        Customer yoo = new Customer("guguttemi", infoOfYoo, 10000);

        HashMap<String, Integer> orderHistory2 = new HashMap();
        orderHistory2.put("아이스 아메리카노", 1);
        orderHistory2.put("얼그레이", 1);
        orderHistory2.put("헤이즐 아메리카노", 2);
        CustomerInfo infoOfLee = new CustomerInfo(orderHistory, 4);
        Customer lee = new Customer("Listerine", infoOfLee, 20000);
        this.customers.add(yoo);
        this.customers.add(lee);

    }

    public static CafeManager getInstance() {
        return cafeManager;
    }


}

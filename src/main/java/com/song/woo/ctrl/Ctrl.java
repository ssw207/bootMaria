package com.song.woo.ctrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.song.woo.model.Customer;
import com.song.woo.repo.CustomerRepository;



@Controller
public class Ctrl {
		//레파지토리 의존적주입
		@Autowired
		CustomerRepository repository;
		
		//구동시 인덱스페이지로 이동
		@RequestMapping("/index")
		public String index() {
			return "index";//jsp사용 디펜던시 추가로,  application.properties에 설정한 프리,서프픽스와 합쳐서 물리적jsp파일의 경로를 찾음
		}
				
		@RequestMapping("/save")//url경로를 매핑함
		public String save(){
			//CrudRepository를 상속받아 Dao기능을하는 인터페이스를 사용하여 insert(sqlSessionTemplet의 역할)
			
			repository.save(Arrays.asList(//생성한객체들을 배열로만들로 List타입으로 변경. 
					new Customer("Jack", "Smith"),//생성자 주입을 통해서 setter에 값이 전달되고 이값이 DTO의 맴버필드에 저장됨->객체를 생성
					new Customer("Adam", "Johnson"),
					new Customer("Kim", "Smith"),
					new Customer("David", "Williams"),
					new Customer("Peter", "Davis")));
			
			return "save";
		}
		
		@RequestMapping("/findall")
		public String findAll(Model model){
			String result = "";//결과값을 담을 String객체
			for(Customer cust : repository.findAll()){//테이블의 모든 목록을 조회하는 기능 실행-> List(?)의길이만큼 Dto인 Customer 클래스타입으로 하나씩 꺼냄
				result += cust + "</br>";//꺼낸것을 result 객체에 입력하고 <br>을 이용하여 출력시 한줄 내려가게함
			}
			model.addAttribute("List",result);//모델에 String 객체를 담음 
			return "list";//이동함
		}
		
//		@GetMapping("/findbyid")
//		public String findById(@RequestParam("id") long id){
//			String result = "";
//			result = repository.findOne(id).toString();
//			return result;
//		}
//		
//		@GetMapping("/findbylastname")
//		public String fetchDataByLastName(@RequestParam("lastname") String lastName){
//			String result = "";
//			
//			for(Customer cust: repository.findByLastName(lastName)){
//				result += cust + "</br>"; 
//			}
//			
//			return result;
//		}
}

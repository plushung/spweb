package springMvcController;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spit.Spittle;
import sqltest.sqlt;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path="/REST/")
//@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	sqlt sq=null;
/*	@ResponseBody �ѷ���ֱֵ����Ϊ��Դ��json/xml���������ظ��ͻ��ˣ����ý�����ͼ��������Converter������Դ��ʽ
		@ResponseBody����@RestController����
			ͨ���ͻ�����·���ĺ�׺��ȷ�����ص���Դ��ʽjson/xml������
			*/
	@RequestMapping(path="/*.json",produces="application/json")//produces����ָ��Ҫ��Ӧ��accept����
	public 				//@ResponseBody
	Spittle spi(Model m
			,Spittle spittle) throws IOException{
		m.addAttribute(new Spittle(123,2,"hung",6199,"man"));
		System.out.println(spittle.getUsername()+" json request");
//		BufferedReader br=req.getReader();
//		String s=null;
//		while((s=br.readLine())!=null){
//			System.out.println(s);
//		}
		return new Spittle(123,2,"hung",6199,"man")/*new Spittle(id,type,name,qq,sex)*/;
	}
	@RequestMapping(path="/spit.xml"
			,produces="application/xml")
	public @ResponseBody 
	List<Spittle> spis(HttpServletResponse spo) throws IOException{
//		BufferedReader br=req.getReader();
//		String s=null;
//		while((s=br.readLine())!=null){
//			System.out.println(s);
//		}
		return sq.getSpittle();
	}
	@RequestMapping(path="/spit"
			,produces="text/html")
	public @ResponseBody 
	List<Spittle> spihtml(HttpServletResponse spo) throws IOException{
//		BufferedReader br=req.getReader();
//		String s=null;
//		while((s=br.readLine())!=null){
//			System.out.println(s);
//		}
		System.out.println("html");
		return sq.getSpittle();
	}
}

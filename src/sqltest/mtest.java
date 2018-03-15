package sqltest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import configure.Configure;
import spit.Spittle;



public class mtest {
	static final String INSERTUSERTABLE="insert into usertable (id,username,type,sex,QQ) values(?,?,?,?,?)"; 
	
	@Test
	public void test() throws ClassNotFoundException, SQLException {
		Scanner ss=new Scanner(System.in);
		String k=ss.next();
		ApplicationContext ct=new AnnotationConfigApplicationContext(Configure.class);
		BasicDataSource bds=(BasicDataSource)ct.getBean(DataSource.class);
		sqlt sssq=ct.getBean(sqlt.class);
		DataSource ds=bds;
		JdbcOperations jtemp=new JdbcTemplate(bds);
		
		
		Connection con=null;
		while(!k.equals("stop")){
			try{
			switch(k){
			case "disconnect":sssq.closeall();break;
			case "connect":con=ds.getConnection();System.out.println("ok");break;
			case "new":{
				k=ss.next();String sss[]=k.split("_");
				Spittle sp=new Spittle(Integer.parseInt(sss[0])
						,Integer.parseInt(sss[1])
						,sss[2]
						,Integer.parseInt(sss[3])
						,sss[4]);
				System.out.println(":"+sp.getUsername());
				jtemp.update(INSERTUSERTABLE, 34,"kk3",2,"man",61669);
				break;
			}
			case "qq":{
				Runtime.getRuntime().exec("D:/Tencent/QQ/Bin/QQScLauncher.exe");
				break;
			}
			case "chdir":{
				System.out.println();Runtime.getRuntime().exec("chdir");
				break;
			}
			case "feibonacci":{
				Runtime.getRuntime().exec("C:\\Users\\Hung\\Desktop\\feibonacci.py");
				break;
			}
			case "":
			case "search":{
				PreparedStatement ps=con.prepareStatement("select * from usertable");
				ResultSet s= ps.executeQuery();
				while(s.next()){
					System.out.println(s.getInt("id"));
				}
				break;
			}
			default:break;
			}}catch(Exception e){}
			System.out.println("input:");
		k=ss.next();
		}
	}

}

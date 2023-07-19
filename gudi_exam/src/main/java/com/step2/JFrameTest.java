package com.step2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
// - select문 처리된 결과를 꺼내서 화면에 출력할 수 있다. - CRUD - 꼭 전달 하자
// - 자료구조 . List와  Map대해서 얼마나 경험했는지??? - 읽기와 쓰기
// 주요 메소드
//List - 처음부터 차례대로 담아야 한다.
//2차 학습목표
//폼과 데이터셋을 분리해서 코딩하는 방식 나는 할 수  있다
//implements하는 것은 인터페이스가 온거다
//저게 있으면 나는 내의사와 상관없이 무조건 오버라이딩 해야 한다.- 상속관계, 인터페이스 구현체 클래스 관계 이해-> DI, IoC -> 내가 직접 프레임워크 만들 수 있다.
//java제공하는 reflectionAPI 도움이 필요함
public class JFrameTest extends JFrame implements ActionListener {
	//선언부
	//게으른 인스턴스화 - ApplicationContext - 스프링 컨테이너 - spring-context.jar
	JPanel jp_north = new JPanel();//이른인스턴스화- BeanFactory - spring-bean.jar
	JButton jbtn_select = new JButton("조회");
	JButton jbtn_delete = new JButton("삭제");
	String cols[] = {"글번호","글제목","작성자"};
	//2차 배열에서 첫번째 숫자는 List의 혹은 2차배열의 한 개 로우를 의미하는 주소번지값
	String data[][] = new String[0][3];
	//JTable이 테이블양식을 그려준다면 DefaultTableModel은 그 테이블에 매칭되는 DataSet을
	//객체화 한 클래스 이다. - 설계되었다
	//jt로는 값을 접근하거나 변경,수정,삭제가 불가함
	//dtm으로 수정,추가,삭제가 가능함
	//실제로 메모리는 1층밖에 없다. 그런데 마치 2층이 있는 것처럼 처리함
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable jt = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jt);
	//jvm설치 - rt.jar -> java.lang, java.io, java.net
	List<Map<String, Object>> nList = new ArrayList<>();
	//생성자 선언
	public JFrameTest() {
		//insert here - 나는 낱말카드(setData();메소드 호출)가 들어갈 위치를 알고 있다. 기준이 있다
		setData();
		initDisplay();
		//insert here
	}
	//데이터 수집한 건 데이터 영속성을 위해서 오라클 서버에 저장함 - 젖지않아, 찢어지지 않아
	public void setData() {
		//<> 제네릭 - 읽기와 쓰기 - 자료구조안에 넣는 사람은 사과인지 키위인지 알지만 꺼내는 사람은 모른다
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("N_NO", 1);
		rmap.put("N_TITLE", "단수안내");
		rmap.put("N_WRITER", "관장");
		nList.add(rmap);//0
		rmap = new HashMap<>();
		rmap.put("N_NO", 2);
		rmap.put("N_TITLE", "휴관안내");
		rmap.put("N_WRITER", "강코치");
		nList.add(rmap);//1
		rmap = new HashMap<>();
		rmap.put("N_NO", 3);//2
		rmap.put("N_TITLE", "써머이벤트");
		rmap.put("N_WRITER", "관장");
		nList.add(rmap);		
	}
	//화면그리기
	public void initDisplay() {
		jbtn_select.addActionListener(this);//this는 원본 하나임
		//이벤트 소스(삭제버튼)와 이벤트 처리를 담당하는 핸들러 클래스를 매핑하기
		//버튼누가누르죠? 사용자가... 느끼는건 -JVM - 콜백함수 호출
		jbtn_delete.addActionListener(this);
		jp_north.add(jbtn_select);//속지에 조회버튼 붙이기- 배치
		jp_north.add(jbtn_delete);
		this.add("North", jp_north);
		this.add("Center",jsp);
		//창이 닫힐 때 자원반납 됨
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 450);
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		new JFrameTest();

	}
	//왜 리턴타입은 필요없나요? - 이 메소드 안에서 직접 DefaultTableModel에 담을 거니까 
	//파라미터는요? - 조건검색은 요구사항에 없으니까 필요없다
	//재사용성을 높이는 코딩을 전개하는 첫 단추는 메소드 중심의 코딩을 전개한다
	//함수형 프로그래밍언어 유행, 지지 - 리액트에서는 훅 - Hook(16.8버전)
	public void refreshData() {
		Iterator<Map<String,Object>> iter = nList.iterator();
		Object[] keys = null;
		//초기화 추가해줌
		//기존에 출력된 정보는 지운다
		 while(dtm.getRowCount()>0) {
			 dtm.removeRow(0);
		 }
		for(;iter.hasNext();) {
			HashMap<String,Object> hm = (HashMap)iter.next();
			Vector<Object> v3 = new Vector<>();
			keys = hm.keySet().toArray();//keys[0]=n_no, keys[1]=n_title, keys[2]=n_writer
			v3.add(hm.get(keys[2]));
			v3.add(hm.get(keys[0]));
			v3.add(hm.get(keys[1]));
			dtm.addRow(v3);//메소드 오버로딩을 어겼다
		}
	}
	//시스템에서 이벤트 감지되면 자동으로 호출됨 - 콜백함수 류- 중급자
	//이 코드를 가지고 댓글처리 할 수 있다
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();//버튼 소스의 라벨을 가져옴
		if("삭제".equals(command)) {
			int index = jt.getSelectedRow();//API활용능력 키워보자, 디버깅능력, 문제해결능력 키워보자
			System.out.println("사용자가 선택한 로우는 "+index);//0부터 1부터 시작인지도 파악
			for(int i=0;i<dtm.getRowCount();i++) {//레코드 인덱스 값
				//너 삭제할 로우를 선택했어?
				if(jt.isRowSelected(i)) {
					//현재 화면에서 실제로 데이터를 쥐고 있는 타입은 DefaultTableModel이다.(눈)
					//나는 getValueAt(첫번째-레코드번호, 두번째-컬럼인덱스)
					System.out.println(dtm.getValueAt(i, 0)+" , "+dtm.getValueAt(i, 1)+" , "+dtm.getValueAt(i, 2));//(Array)IndexOutOfBoundException-화면처리시 단골
					//insert here - remove, nList
					nList.remove(index);
				}
				//for() {//위 for문에서 결정된 인덱스에 대응하는 컬럼명 인덱스 정보
					
				//}
			}
		}
		else if("조회".equals(command)) {//너 조회버튼 누른거야?
			System.out.println("조회");
			//데이터셋
			//나는 0을 출력하고 있다면.... 무엇을 안했나 - setData()호출하지 않아서....
			//생성자 안에서 하였다 - 객체 -> 포인터+생성자(함수형태를 띄고 있다)
			System.out.println(nList.size());//1 - 초기화가 되었다
			//테이블 양식을 그려주는 건 JTable이고 실제 데이터를 쥐고 있는건 DefaultTableModel
			Object[] obj = new Object[] {1,true,"안녕"};//null, null, null
			Vector<String> v = new Vector<>();
			v.add("1");
			v.add("단수안내");
			v.add("관장");
			List<?> v2 = new Vector<>();
			ArrayList<?> al = new ArrayList<>();
			Object obj2 = new Object();
			//어떡하지?
			//List, Map자료구조는 읽기와 쓰기
			//Iterator는 꺼내기 관점
			Iterator<Map<String,Object>> iter = nList.iterator();
			Object[] keys = null;
			//초기화 추가해줌
			//기존에 출력된 정보는 지운다
			 while(dtm.getRowCount()>0) {
				 dtm.removeRow(0);
			 }
			for(;iter.hasNext();) {
				HashMap<String,Object> hm = (HashMap)iter.next();
				Vector<Object> v3 = new Vector<>();
				keys = hm.keySet().toArray();//keys[0]=n_no, keys[1]=n_title, keys[2]=n_writer
				v3.add(hm.get(keys[2]));
				v3.add(hm.get(keys[0]));
				v3.add(hm.get(keys[1]));
				dtm.addRow(v3);//메소드 오버로딩을 어겼다
			}
			//초기화 여기서 해도 상관없나요?
			//매번 조회가 눌릴 때 마다 기존에 정보가 남아있어서 누적 출력된다.- 문제제기- 버그 - 초기화 - 기초가아님
		}//////////end of 조회버튼 눌렀을 때
	}/////////////end of actionPerformed

}////////////////end of JFrameTest
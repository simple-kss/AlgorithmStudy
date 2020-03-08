package kakao2019blind;

import java.util.ArrayList;
import java.util.StringTokenizer;


class Solution {
    	enum Com {
		Enter, Leave;
	}
	
	static class Command {
		public Command() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Command(Com cmd, String id) {
			super();
			this.cmd = cmd;
			this.id = id;
		}

		Com cmd;
		String id;
	}
	
	static class Data {
		String id;
		String nick;
	}
    
    public String[] solution(String[] record) {

        Command[] cmList = new Command[100000];
		Data[] daList = new Data[100000];
		int cmListCnt = 0;
		int daListCnt = 0;
		
		
		int len = record.length;
		for (int i = 0; i < len; i++) {
			StringTokenizer stk = new StringTokenizer(record[i]);
			
			String cm = stk.nextToken();
			if( cm.equals("Enter")) {
				String id = stk.nextToken();
				String nick = stk.nextToken();
				
				// cmd 에 저장
				Command command = new Command();
				command.cmd = Com.Enter;
				command.id = id;
				cmList[cmListCnt] = command;
				cmListCnt++;
				
				// db에 저장
				Data data = new Data();
				data.id = id;
				data.nick = nick;
				daList[daListCnt] = data;
				daListCnt++;
			}
			else if( cm.equals("Leave")) {
				String id = stk.nextToken();
				
				// cmd 에 저장
				Command command = new Command();
				command.cmd = Com.Leave;
				command.id = id;
				cmList[cmListCnt] = command;
				cmListCnt++;
				
			}
			else if( cm.equals("Change")) {
				String id = stk.nextToken();
				String nick = stk.nextToken();
				
				// db에 저장
				for (int j = 0; j < daListCnt; j++) {
					if( daList[j].id.equals(id) )
						daList[j].nick = nick;
				}
			}
		}
        
        String[] result = new String[cmListCnt];
        int resultCnt = 0;
		
		// 이제 cmList에서 하나씩 긁어와서 사용.

		for (int i = 0; i < cmListCnt; i++) {
	        StringBuilder s = new StringBuilder();
			String selectId = cmList[i].id;
			String nick = null;
			
			for (int j = 0; j < daListCnt; j++) {
				if( daList[j].id.equals(selectId) )
					nick = daList[j].nick;
			}
			s.append(nick);
			if(cmList[i].cmd == Com.Enter) {
				s.append("님이 들어왔습니다.");
			}
			else if(cmList[i].cmd == Com.Leave) {
				s.append("님이 나갔습니다.");
			}
			
            result[resultCnt++] = new String(s);
		}
        return result;
    }
}
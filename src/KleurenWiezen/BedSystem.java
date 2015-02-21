package KleurenWiezen;

import java.util.ArrayList;

public class BedSystem {
	//0 => nothing yet            	//21  => 8 spades				//42  => 11 diamonds					//63  => troel with 5
	//1 => pas troel				//22  => 9 spades 				//43  => 12 diamonds					//64  => I join troel
	//2 => waited					//23  => 10 spades 				//44  => 13 diamonds					//65  => in spades
	//3 => asked spades				//24  => 11 spades				//45  => 5 hearts						//66  => in clubs
	//4 => asked clubs		        //25  => 12 spades				//46  => 6 hearts						//67  => in diamonds
	//5 => asked diamonds			//26  => 13 spades				//47  => 7 hearts						//68  => in hearts
	//6 => asked hearts				//27  => 5 clubs				//48  => 8 hearts
	//7 => small misery				//28  => 6 clubs				//49  => 9 hearts
	//8 => Abundance				//29  => 7 clubs				//50  => 10 hearts
	//9 => big misery				//30  => 8 clubs				//51  => 11 hearts
	//10 => naked misery			//31 =>  9 clubs				//52  => 12 hearts
	//11 => solo slim				//32  => 10 clubs				//53  => 13 hearts
	//12 => pas						//33  => 11 clubs				//54  => troel with 4th ace
	//13 => join spades				//34  => 12 clubs				//55  => troel with king
	//14 => join clubs				//35  => 13 clubs				//56  => troel with Queen
	//15 => join diamonds			//36  => 5 diamonds				//57  => troel with jack
	//16 => join hearts				//37  => 6 diamonds				//58  => troel with 10
	//17 => pas-parole				//38  => 7 diamonds				//59  => troel with 9
	//18 => 5 spades				//39  => 8 diamonds				//60  => troel with 8
	//19 => 6 spades				//40  => 9 diamonds				//61  => troel with 7
	//20 => 7 spades				//41  => 10 diamonds			//62  => troel with 6
	

	
	
	//going in a color
	//[game,amount,asking player, joining player]
	//[game,amount,player]
	
	// solo,abondance
	//[game,troef,player]
	
	//misery
	//[game,player]
	//[game,player,player]
	//[game]
	
	//troel game == 1
	//[game,asking player, joining player]
	
	private int[] highestBed = new int[]{0,0,0,0};
	
	private static final int Max =69;
	public static int getMaxBeds(){
		return Max;
	}
 	public static String translate(int bed){
		switch(bed){
		case(0):return "                  ";
		case(1):return " pas troel        ";
		case(2):return " I wait           ";
		case(3):return " I ask spades     ";
		case(4):return " I ask clubs      ";
		case(5):return " I ask diamonds   ";
		case(6):return " I ask hearts     ";
		case(7):return " small misery     ";
		case(8):return " abundance        ";
		case(9):return " big misery       ";
		case(10):return " naked misery     ";
		case(11):return " solo slim        ";
		case(12):return " I fold           ";
		case(13):return " I join spades    ";
		case(14):return " I join clubs     ";
		case(15):return " I join diamonds  ";
		case(16):return " I join hearts    ";
		case(17):return " pas-parole       ";	
		case(18):return " 5 spades         ";
		case(19):return " 6 spades         ";
		case(20):return " 7 spades         ";
		case(21):return " 8 spades         ";
		case(22):return " 9 spades         ";
		case(23):return " 10 spades        ";
		case(24):return " 11 spades        ";
		case(25):return " 12 spades        ";
		case(26):return " 13 spades        ";
		case(27):return " 5 clubs          ";
		case(28):return " 6 clubs          ";
		case(29):return " 7 clubs          ";
		case(30):return " 8 clubs          ";
		case(31):return " 9 clubs          ";
		case(32):return " 10 clubs         ";
		case(33):return " 11 clubs         ";
		case(34):return " 12 clubs         ";
		case(35):return " 13 clubs         ";
		case(36):return " 5 diamonds       ";
		case(37):return " 6 diamonds       ";	
		case(38):return " 7 diamonds       ";
		case(39):return " 8 diamonds       ";
		case(40):return " 9 diamonds       ";
		case(41):return " 10 diamonds      ";
		case(42):return " 11 diamonds      ";
		case(43):return " 12 diamonds      ";
		case(44):return " 13 diamonds      ";
		case(45):return " 5 hearts         ";
		case(46):return " 6 hearts         ";
		case(47):return " 7 hearts         ";
		case(48):return " 8 hearts         ";
		case(49):return " 9 hearts         ";
		case(50):return " 10 hearts        ";
		case(51):return " 11 hearts        ";
		case(52):return " 12 hearts        ";
		case(53):return " 13 hearts        ";
		case(54):return " troel with ace  ";
		case(55):return " troel with king ";
		case(56):return " troel with Queen";
		case(57):return " troel with jack ";
		case(58):return " troel with 10   ";
		case(59):return " troel with 9    ";
		case(60):return " troel with 8    ";
		case(61):return " troel with 7    ";
		case(62):return " troel with 6    ";
		case(63):return " troel with 5    ";
		case(64):return " I join troel    ";
		case(65):return " in spades       ";
		case(66):return " in clubs        ";
		case(67):return " in diamonds     ";
		case(68):return " in hearts       ";
		}	
		return " Error";
	}
	
	private ArrayList<int[]> beds;
	private boolean[][] options;
	private int starter = 0;
	private int curr = 0;
	private int round;
	private boolean troelFound = false;
	
	public int[] getGame(){
		return highestBed;
	}
	
	public BedSystem(){
		beds = new ArrayList<int[]>();
		beds.add(new int[4]);
		
		options = new boolean[4][Max];	
		//initiate options (pas troel and troel)
		setOption(1, true);
		enable(54,64);
		round = 0;
	}
	
	public int getRound() {
		return round;
	}
	
	public ArrayList<int[]> getBeds() {
		return beds;
	}
	
	public int getCurrtPlayer(){
		return curr;
	}
	
	public boolean finished(){
		for(boolean b: cannotSpeak){
			if(!b)return false;
		}
		return true;
	}
	
	//not finished
	public boolean setNextBed(int bed){
		beds.get(round)[curr] = bed;
		updateOptions();
		//next player is
		nextPlayer();
		return finished();
	}
	
	
	//keeps whether a player can still do something
	private boolean[] cannotSpeak = new boolean[4];
	private boolean[] passed = new boolean[4];
	//keeps which player asked what color
	//0 = spades,...
	private int[] asked = new int[]{-1,-1,-1,-1};
	//keeps how many times a player has asked a color
	//only important in case of asking and small misery
	private int[] numberAsked = new int[4];
	//keeps track of who joined who
	private int[] joined = new int[]{-1,-1,-1,-1};
	//stores what color a player has chosen when he goes in a color alone
	private int[] chosen = new int[]{-1,-1,-1,-1};
	//remembers is someone said pas-parole already
	private boolean[] parol = new boolean[4];
	
	private void updateOptions(){
		int lastBed = beds.get(round)[curr];
		//handles troel
		if(lastBed > 53 & lastBed < 64){
			System.out.println("53<lastBed<64");
			highestBed = new int[]{1,lastBed-54,curr,-1};
			cannotSpeak[curr]=true;
		}
		//removing the wait option after first players turn
		//and handling if he chose to wait
		if(round ==1 & curr == starter){
			System.out.println("waiting option");
			setOption(2,curr,false);
			//the player has waited
			if(lastBed == 2){
				//current player cannot do anything else anymore
				disable(3,12,curr);
				chosen[curr]=5;
			}
		}
		
		//handles the first round and troel
		if(((round == 1 & starter !=0) |(starter == 0 & round == 0))& ((curr + 1)%4 == starter)){
			//System.out.println("round="+round + "  starter="+starter+ "  curr=" +curr);
			//remove troel options
			disable(54,64);
			//pastroel cannot be said again
			setOption(1,false);
			if(highestBed[0]==1){
				//Enable options that are above troel
				enable(10,13);
				//enable joining troel
				setOption(64,true);
			}else{
				//no troel
				//enable normal options 
				enable(3,13);
				//set waiting option for the first player
				setOption(2,starter,true);
			}
		}
		//joining troel
		if(lastBed == 64){
			System.out.println("lastBed: " + 64);
			highestBed[3] = curr;
			setOption(64,false);
			troelFound = true;
			cannotSpeak[curr] = true;
		}
		// options 3 to 6 (asked a color)
		if(lastBed >2 & lastBed < 7 ){
			System.out.println("2< lastBed<7 ");
			//increase the number of times this player has asked a color
			numberAsked[curr]++;
			//this color cannot be asked again
			setOption(lastBed,false);
			//curr player can stay in this color
			setOption(lastBed,curr,true);
			//curr player cannot do anything else anymore
			disable(7,12,curr);
			//players can join
			for(int i = 0;i<4;i++){
				//only players that have not joined anybody else
				if(joined[i]==-1)setOption(lastBed + 10,i,true);
			}
			//players that are joined by someone cannot join someone else
			for(int i = 0;i<4;i++){
				//only players that have not joined anybody else
				if(joined[i]!=-1)setOption(lastBed + 10,joined[i],false);
			}
			//disable going alone in this color
			setOption(lastBed +62,false);
			//curr player cannot join himself
			setOption(lastBed + 10,curr,false);
			asked[lastBed-3]=curr;	
			//if this player asked a different color already disable that other color
			for(int i = 0;i<4;i++){
				if(asked[i]==curr& i != lastBed-3){
					//Disable joining option
					setOption(i + 13,false);
				}
			}
			//check if the player can ask again
			if(numberAsked[curr] == 2){
				//disable other options
				disable(3,8,curr);
				//next time the player has to chose a color
				for(int i = 0;i<4;i++){
					if(asked[i]==-1|asked[i]==curr)setOption(i+65,curr,true);
				}
			}
		}
		
		//joining in a color:
		if(lastBed>12& lastBed<17){
			System.out.println("12<lastBed<17 ");
			//keep track of the chosen color of the curr player
			chosen[curr]=lastBed-13;
			//remove previous asked color from joining
			for(int i = 0;i<4;i++){
				if(asked[i]==curr)setOption(13+i,false);
			}
			//remove other options for curr player
			disable(3,12,curr);
			joined[curr]=asked[lastBed-13];
			//disable joining for curr player
			disable(13,17,curr);
			//disable joining in the same color
			setOption(lastBed,false);
			//remove asking options for the joined player
			disable(3,7,joined[curr]);
			//remove going alone in this color option
			setOption(lastBed,false);
			//setting biggest Bed
			int[] thisBed = new int[]{lastBed-10,8,asked[lastBed-13],curr};
			if(highestBed[0] == 0){
				//there was not yet a higher bed
				highestBed = thisBed;
			}else if(highestBed[0] == 7){
				//someone went small misery
				//this means the bed is already higher than 10=> enable pas-parole
				setOption(17,curr,true);
				if(highestBed.length == 2){
					//can the small misery player still ask?
					if(passed[6-curr-joined[curr]-highestBed[1]]|chosen[6-curr-joined[curr]-highestBed[1]]!=-1){
						//disable asking
						disable(3,7,highestBed[1]);
						//enable going alone
						for(int i = 65;i<69;i++){
							setOption(i,highestBed[1],true);
						}
						for(int i = 0;i<4;i++){
							if(-1<chosen[i]& chosen[i]<4)setOption(chosen[i]+65,highestBed[1],false);
						}
					}
					thisBed[1]=10;
					highestBed = thisBed;
				}else if(highestBed.length == 3){
					thisBed[1]=11;
					highestBed = thisBed;
				}
			}else if(highestBed[0]< thisBed[0]){
				//this team goes in a higher color
				//allow the other team to go higher
				setOption(14+highestBed[1] + 9*(highestBed[0]-3),highestBed[3],true);
				thisBed[1]=highestBed[1];
				highestBed = thisBed;
			}else{
				//the other team goes in a higher color
				//allow this team to go higher
				setOption(14+highestBed[1] + 9*(thisBed[0]-3) ,curr,true);
			}
			//let other people speak
			letSpeak();
		}
		//current player goes alone
		if(64<lastBed& lastBed <69){
			System.out.println("64<lastBed<69 ");
			//other players cannot go in this color
			if(highestBed[0]==11){
				//solo slim: disable lower colors
				for(int i =65;i<lastBed;i++){
					setOption(i,false);	
				}
				highestBed = new int[]{11,13,lastBed-65,curr};
			}else if(highestBed[0]==8){	
				if(highestBed[2] != -1){
					//not the first player that chooses his color
					if(highestBed[2]<lastBed-65){
						//curr player goes in a higher color
						setOption(23+highestBed[2]*9,highestBed[3],true);
						highestBed = new int[]{8,9,lastBed-65,curr};
					}else{
						//curr player goes in a lower color
						setOption(23+(lastBed-65)*9,curr,true);
					}
				}else{
					highestBed = new int[]{8,9,lastBed-65,curr};
				}
			}
			
			//other players cannot go in this color
			setOption(lastBed,false);
			
			//disable other choices for this player
			disable(65,69,curr);
			disable(7,12,curr);
			//disable joining the current player 
			for(int i=0;i<4;i++){
				if(asked[i]==curr)setOption(i+13,false);
			}
			//store what color the current player chose
			chosen[curr]=lastBed-65;
			//set curr player next option
			if(highestBed[0] ==0){
				//no higherBed
				setOption(18+(9*(lastBed-65)),curr,true);
			}else if(highestBed[0]==7){
				//higherBed is small misery
				switch(highestBed.length){
				case(3):setOption(22+(9*(lastBed-65)),curr,true);break;
				case(2):setOption(20+(9*(lastBed-65)),curr,true);break;
				}
			}else if(highestBed[0]<7 & highestBed[0]>2 & highestBed.length == 4){
				//Highest bed is two people going in a color
				if(highestBed[0]<lastBed-62){
					//curr goes in a higher color
					setOption((highestBed[1]+13)+(9*chosen[curr])-3,curr,true);
				}else{
					//curr player goes in a lower color
					setOption((highestBed[1]+13)+(9*chosen[curr])-2,curr,true);
				}
			}else if(highestBed[0]<7 & highestBed[0]>2 & highestBed.length == 3){
				//Highest bed is one player going in a color
				if(highestBed[0]<lastBed-62){
					//curr goes in a higher color
					setOption((highestBed[1]+13)+(9*chosen[curr]),curr,true);
				}else{
					//curr player goes in a lower color
					setOption((highestBed[1]+13)+(9*chosen[curr])+1,curr,true);
				}
			}
			//let speak who can speak
			letSpeak();
		}
		//upBidding
		if( 17 < lastBed & lastBed < 54){
			System.out.println("17<lastBed<54 ");
			//disable this bed
			setOption(lastBed,curr,false);		
			//enable pas-parole?
			if(((lastBed-18)%9)+5>9 & joined[curr]!=-1){
				//enable pasparole
				setOption(17,curr,true);
			}
			//set the highest Bed
			if(highestBed[0]==8){
				//abundance
				highestBed = new int[]{8,((lastBed-18)%9)+5,((lastBed-18)/9),curr};
			}else if(joined[curr]==-1){
				//curr player is alone
				//disable asking options for players that went small misery
				if(highestBed[0]==7){
					for(int i = 1;i<highestBed.length;i++){
						disable(3,7,highestBed[i]);
					}
				}
				//set highest bed
				highestBed = new int[]{((lastBed-18)/9)+3,((lastBed-18)%9)+5,curr};
			}else{
				//current player has joined someone
				highestBed = new int[]{((lastBed-18)/9)+3,((lastBed-18)%9)+5,joined[curr],curr};
			}
			//allow other players to speak again
			letSpeak();	
			//let players go higher
			//loop over the players
			for(int i = 0;i<4;i++){
				//ignore people that have passed
				if(passed[i])continue;
				//ignore people that are joined by someone
				if(cannotSpeak[i])continue;
				//allow the player to go higher
				if(chosen[i]!=-1 & chosen[i]!=4){
					//only if the player has chosen a color
					if(joined[curr]!=-1 &joined[i]!=-1){
						//two teams of two
						if(chosen[i]< highestBed[0]-3){
							if(highestBed[1]+1<14)setOption((highestBed[1]+13)+(9*chosen[i])+1,i,true);
							setOption((highestBed[1]+13)+(9*chosen[i]),i,false);
						}else{
							setOption((highestBed[1]+13)+(9*chosen[i]),i,true);	
							setOption((highestBed[1]+13)+(9*chosen[i])-1,i,false);
						}
					}else if(joined[curr]!=-1 &joined[i]==-1){
						//ith player is alone against a team of two
						if(chosen[i]< highestBed[0]-3){
							//lower color
							setOption((highestBed[1]+13)+(9*chosen[i])-2,i,true);	
							setOption((highestBed[1]+13)+(9*chosen[i])-3,i,false);
						}else{
							setOption((highestBed[1]+13)+(9*chosen[i])-3,i,true);	
							setOption((highestBed[1]+13)+(9*chosen[i])-4,i,false);
						}	
					}else if(joined[curr]==-1 & joined[i]!=-1){
						//ith player is in team of two agains a player alone
						if(chosen[i]< highestBed[0]-3){
							//lower color
							if(highestBed[1]+4<14)setOption((highestBed[1]+13)+(9*chosen[i])+4,i,true);
							setOption((highestBed[1]+13)+(9*chosen[i])+3,i,false);
						}else{
							if(highestBed[1]+3<14)setOption((highestBed[1]+13)+(9*chosen[i])+3,i,true);	
							setOption((highestBed[1]+13)+(9*chosen[i])+2,i,false);
						}
					}else if(joined[curr]==-1 &joined[i]==-1){
						//ith player is alone against a player that is alone
						if(chosen[i]< chosen[curr]){
							//lower color
							if(highestBed[1]<13)setOption((highestBed[1]+13)+(9*chosen[i])+1,i,true);
							setOption((highestBed[1]+13)+(9*chosen[i]),i,false);
						}else{
							setOption((highestBed[1]+13)+(9*chosen[i]),i,true);	
							setOption((highestBed[1]+13)+(9*chosen[i])-1,i,false);
						}
					}
				}	
			}
		}
		//pas-parole
		if(lastBed == 17){
			parol[curr] = true;
			//disable pas-parole for curr player
			setOption(17,curr,false);
			//set chosen for team mate
			chosen[joined[curr]]= chosen[curr];
			//disable going alone for this player's team mate
			for(int i = 0;i<4;i++){
					setOption(i+65,joined[curr],false);
			}
			//enable bed for team mate
			if(highestBed[0]!=7){
				//not small misery
				if(highestBed.length == 4){
					//against a team
					if(chosen[curr]< highestBed[0]-3){
					//other team is in higher color
						if(highestBed[1]+1<14)setOption((highestBed[1]+13)+(9*chosen[curr])+1,joined[curr],true);
						setOption((highestBed[1]+13)+(9*chosen[curr])+1,curr,false);
					}else{
						setOption((highestBed[1]+13)+(9*chosen[curr]),joined[curr],true);	
						setOption((highestBed[1]+13)+(9*chosen[curr])-1,curr,false);
					}					
				}else if(highestBed.length==3) {
					if(chosen[curr]< highestBed[0]-3){
						//other team is in higher color
							if(highestBed[1]+1<14)setOption((highestBed[1]+13)+(9*chosen[curr])+4,joined[curr],true);
							setOption((highestBed[1]+13)+(9*chosen[curr])+4,curr,false);
						}else{
							setOption((highestBed[1]+13)+(9*chosen[curr])+3,joined[curr],true);	
							setOption((highestBed[1]+13)+(9*chosen[curr])+3,curr,false);
						}
				}
			}else if(highestBed[0]==7){
				//small misery
				if(highestBed.length==3){//security test: normally no other possibility
					setOption(25+(9*chosen[curr]),joined[curr],true);	
					setOption(25+(9*chosen[curr]),curr,false);
				}	
			}
			//next player should be curr player's team mate
			cannotSpeak[0]=true;
			cannotSpeak[1]=true;
			cannotSpeak[2]=true;
			cannotSpeak[3]=true;
			cannotSpeak[joined[curr]]=false;
			//change joined
			int temp = joined[curr];
			joined[curr]=-1;
			joined[temp]=curr;
		}
	
		
		//small misery
		if(lastBed == 7){
			System.out.println("lastBed: " + 7);
			//keep what this player has asked
			chosen[curr]=4;
			//calculate the number of players that go small misery
			int amount = 0;
			for(int i:chosen){
				if(i ==4)amount++;
			}
			//a team might want to go higher
			if(highestBed[0]!=0 & highestBed[0] != 7){
				if(amount ==2){
					setOption(25+(9*chosen[highestBed[highestBed.length-1]]),highestBed[highestBed.length-1],true);
				}else if(amount == 1){
					setOption(23+(9*chosen[highestBed[highestBed.length-1]]),highestBed[highestBed.length-1],true);
				}
				//no players can ask again
				disable(3,7);
				//allow the 4th player to go alone
				for(int i = 65;i<69;i++){
					setOption(i,6-curr-highestBed[2]-highestBed[3],true);
				}
				for(int i = 0;i<4;i++){
					if(-1<chosen[i]& chosen[i]<4)setOption(chosen[i]+65,6-curr-highestBed[2]-highestBed[3],false);
					if(asked[i]!=-1& asked[i]!=6-curr-highestBed[2]-highestBed[3])setOption(i+65,6-curr-highestBed[2]-highestBed[3],false);
				}
			}
			//increase the number of times this player has asked a color
			numberAsked[curr]++;
			//set the highestBed	
			highestBed = new int[amount+1];
			highestBed[0]=7;
			int j=1;
			for(int i =0;i<4;i++){
				if(chosen[i]==4){
					highestBed[j]=i;
					j++;
				}
			}
			//this player cannot go higher than small misery anymore
			disable(7,12,curr);
			//big misery is still possible
			setOption(9,curr,true);
			//3 people go small misery=>disable all normal options
			if(amount == 3){
				disable(3,8);
			}
			//let other players speak again
			letSpeak();
		}
		
		//abundance
		if(lastBed == 8){
			System.out.println("lastBed: " + 8);
			//disable options lower than abundance
			disable(3,8);
			//joining in a color and going alone is also not possible
			disable(13,17);
			//abundance cannot be tried again by this person
			setOption(8,curr,false);
			//set going options for this player
			for(int i=65;i<69;i++){
				setOption(i,curr,true);
			}
			highestBed = new int[]{8,9,-1,curr};
			//someone that has not passed yet can still speak
			letSpeak();
		}
		
		//big misery
		if(lastBed == 9){
			System.out.println("lastBed: " + 9);
			//the rest can only go higher or join
			disable(3,9);
			//big misery cannot be tried again by this person
			setOption(9,curr,false);
			//joining in a color and going alone is also not possible
			disable(13,69);			
			//someone went abundance => disable their going options
			if(highestBed[0]==8)disable(65,69);
			//did someone already go big misery
			if(highestBed[0]== 9){
				//Someone already went big misery
				if(highestBed.length == 2){
					//only one player went already big misery
					highestBed = new int[]{9,highestBed[1],curr};
				}else{
					//two players already went big misery (all four players have to go big misery now)
					highestBed = new int[]{9,highestBed[1],highestBed[2],curr};
					//disable big misery option
					setOption(9,false);
				}
			}else{
				highestBed = new int[]{9,curr};
			}
			//someone that has not passed yet can still speak
			letSpeak();
		}
		
		//naked misery
		if(lastBed == 10){
			System.out.println("lastBed: " + 10);
			//the rest can only go higher or join
			disable(3,10);
			//joining in a color is also not possible
			disable(13,17);
			//someone went abundance => disable their going options
			if(highestBed[0]==8)disable(65,69);
			//was it troel?
			if(highestBed[0]==1){
				//disable joining troel option
				setOption(64,false);
			}
			//did someone already go naked misery
			if(highestBed[0]== 10){
				//Someone already went naked misery
				if(highestBed.length == 2){
					//only one player went already naked misery
					highestBed = new int[]{10,highestBed[1],curr};
				}else{
					//two players already went naked misery (all four players have to go naked misery now)
					highestBed = new int[]{10,highestBed[1],highestBed[2],curr};
					//disable naked misery option
					setOption(10,false);
				}
			}else{
				highestBed = new int[]{10,curr};
			}
			//someone that has not passed yet can still speak
			letSpeak();
		}
		//Solo slim
		if(lastBed == 11){
			System.out.println("lastBed: " + 11);
			//disable this option for this player
			setOption(lastBed,curr,false);
			//disable normal options
			disable(3,11);
			//disable joining
			disable(13,17);
			//someone went abundance => disable their going options
			if(highestBed[0]==8)disable(65,69);
			//set the highest bed
			highestBed = new int[]{11,13,-1,curr};
			//set going options for this player
			for(int i=65;i<69;i++){
				setOption(i,curr,true);
			}
			//someone that has not passed yet can still speak
			letSpeak();
		}
		//passed
		if(lastBed == 12){
			System.out.println("lastBed: " + 12);
			//set this player passed  status
			passed[curr]=true;
			//disable joining this player
			for(int i =0;i<4;i++){
				if(asked[i]==curr)setOption(13+i,false);
			}
			//let the joined player speak again
			if(joined[curr]!=-1){
				//disable joining for joined player
				disable(13,17,joined[curr]);
				//allow for the joined player to go alone
				//enable all colors that have not been chosen or asked yet
				if(highestBed[0]<8){
					if(!parol[joined[curr]]){
						//only when the player has not yet said pas-parole
						for(int i = 65;i<69;i++){
							setOption(i,joined[curr],true);
						}
						for(int i = 0;i<4;i++){
							if(-1<chosen[i]& chosen[i]<4)setOption(chosen[i]+65,joined[curr],false);
							if(asked[i]!=-1& asked[i]!=joined[curr])setOption(i+65,joined[curr],false);
						}
					}
				}
				//next player should be the team mate
				cannotSpeak[0]=true;
				cannotSpeak[1]=true;
				cannotSpeak[2]=true;
				cannotSpeak[3]=true;
				cannotSpeak[joined[curr]]=false;
				cannotSpeak[curr]=true;
				joined[curr]=-1;
			}else{
				letSpeak();
				//if there is a player that cannot be joined again: disable asking and enable going alone
				//going alone has to become enabled
				int number = 0;
				int player = -1;
				for(int i =0;i<4;i++){
					if(cannotSpeak[i]){
						number++;
					}else{
						player=i;
					}
				}
				if(number ==3){
					//disable asking options
					disable(3,7);
					//enable going alone options for the one that is alone
					if(highestBed[0]<8){
						//only when the player has not chosen anything yet
						if(chosen[player]==-1){
							//loop over colors
							for(int i = 0; i<4;i++){
								boolean chos = false;
								for(int a :chosen){
									if(i==a){
										chos=true;
										break;
									}
								}
								if(!chos)setOption(i+65,player,true);
							}
						}
					}
				}
			}
			//set the chosen color for curr player to -1
			chosen[curr]=-1;
		}
	}
	

	private void nextPlayer(){
		if(!finished()){
			curr = (curr+1)%4;
			if(curr == 0){
				round ++;
				beds.add(new int[4]);
			}
			if(cannotSpeak[curr]){
				nextPlayer();
			}
		}
	}
	
	//helper functions
	private void disable(int from, int to, int player) {
		//included from, exclude to
		for(int i =from;i<to;i++){
			setOption(i,player,false);	
		}
	}
	
	private void disable(int from,int to){
		//included from, exclude to
		for(int i =from;i<to;i++){
			setOption(i,false);	
		}
	}
	
	private void enable(int from,int to){
		//included from, exclude to
		for(int i =from;i<to;i++){
			setOption(i,true);	
		}
	}
	
	//lets all the people Speak that have not passed exclude players that are joined by another player
	//or players that have the highest bed
	private void letSpeak(){
		for(int i =0;i<4;i++){
			if(!passed[i])cannotSpeak[i]=false;
			else cannotSpeak[i] =true;
		}
		//a player that is joined cannot speak
		for(int i :joined){
			if(i!=-1)cannotSpeak[i]=true;
		}
		if(highestBed[0]==7|highestBed[0]==9|highestBed[0]==10){
			for(int i = 1;i<highestBed.length;i++){
				cannotSpeak[highestBed[i]]=true;
			}
		}else if(highestBed[0]!=0 & highestBed[0] != 1){
			cannotSpeak[highestBed[highestBed.length-1]]=true;
		}
	}

	
	
	//secondary help functions
	private void setOption(int option, boolean value){
		options[0][option]=value;
		options[1][option]=value;
		options[2][option]=value;
		options[3][option]=value;
	}
	
	private void setOption(int option, int player,boolean value){
		options[player][option]= value;
	}
	
	public boolean[] getOptions(int seat) {
		return options[seat];
	}
	public boolean isTroelFound() {
		return troelFound;
	}
	public void setStarter(int starter) {
		curr = starter;
		this.starter = starter;
	}
}

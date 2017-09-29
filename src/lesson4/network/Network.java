package lesson4.network;

import java.util.ArrayList;

public class Network {
    public class Member{
        public class item{
            public String name;
            public item(String name){
                this.name = name;
            }

        }
        final private String name;
        private ArrayList<Member> friends;

        public Member(String name){
            this.name = name;
            this.friends = new ArrayList<>();
        }
        public item additem(String name){
           return new item(name);
        }

        public void leave(){

        }
    }
    //Network----------------------------------------------------------------------------------
    private ArrayList<Member> members = new ArrayList<>();

    public Member enroll(String name){
        //this == new Network() == net1 == newmember.outer
        Member newmember = new Member(name);
        members.add(newmember);
        return newmember;
    }

    public void unenroll(Member member){
        members.remove(member);
    }

    public void leave(){
        members.remove(this);
    }
}

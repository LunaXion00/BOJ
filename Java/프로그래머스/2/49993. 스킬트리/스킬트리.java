class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        loop:for(String skilltree: skill_trees){
            int tier = 0;
            for(int i = 0; i<skilltree.length(); i++){
                char target = skilltree.charAt(i);
                if(skill.contains(String.valueOf(target))) {
                    if(skill.indexOf(target)==tier) {
                        tier++;
                        continue;
                    }
                    else if(skill.indexOf(target)<tier) continue;
                    else continue loop;
                }
            }
            answer++;
        }
        return answer;
    }
}
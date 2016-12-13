/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;


/**
 *
 * @author Hodes
 */

@Entity
@Table(name = "DB_skills_table")
public class DataBaseSkills implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "skillsID")
     private Integer skillsID;
    
    @Column(name = "skill_category")
     private String skill_category;
    
    @Column(name = "skillName")
     private String skillName;
    
    public DataBaseSkills (){}
    
    public DataBaseSkills(Integer skillsID, String skill_category, String skillName){
        this.skillsID = skillsID;
        this.skill_category = skill_category;
        this.skillName = skillName;       
    }

    /**
     * @return the skillsID
     */
    public Integer getSkillsID() {
        return skillsID;
    }

    /**
     * @param skillsID the skillsID to set
     */
    public void setSkillsID(Integer skillsID) {
        this.skillsID = skillsID;
    }

    /**
     * @return the skill_category
     */
    public String getSkill_category() {
        return skill_category;
    }

    /**
     * @param skill_category the skill_category to set
     */
    public void setSkill_category(String skill_category) {
        this.skill_category = skill_category;
    }

    /**
     * @return the skillName
     */
    public String getSkillName() {
        return skillName;
    }

    /**
     * @param skillName the skillName to set
     */
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}

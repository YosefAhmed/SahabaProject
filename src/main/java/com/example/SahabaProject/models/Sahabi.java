package com.example.SahabaProject.models;
import com.example.SahabaProject.common.Constants;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.List;

@Node
@RequiredArgsConstructor
@Setter
public class Sahabi extends Person{
    private  String islam_Date;
    private String characteristics;
    private  String education;
    @Relationship(type = "Participated", direction = Relationship.Direction.OUTGOING)
    private List<Battle> participatedBattles;
    private  List<String> sayingsAndHadiths;
    private String roleOrActivity;
    private List<String> historicalEvents;
    private  List<String> charitableActivities;
    private  String biography;



    public String getIslam_Date() {
        return (String) Constants.checkDataStatus(islam_Date);
    }

    public String getCharacteristics() {
        return (String) Constants.checkDataStatus(characteristics);
    }

    public String getEducation() {
        return (String) Constants.checkDataStatus(education);
    }

    public Object getParticipatedBattles() {
        return Constants.checkDataStatus(participatedBattles);
    }

    public Object getSayingsAndHadiths() {
        return Constants.checkDataStatus(sayingsAndHadiths);
    }

    public String getRoleOrActivity() {
        return (String) Constants.checkDataStatus(roleOrActivity);
    }

    public Object getHistoricalEvents() {
        return Constants.checkDataStatus(historicalEvents);
    }

    public Object getCharitableActivities() {
        return Constants.checkDataStatus(charitableActivities);
    }

    public String getBiography() {
        return (String) Constants.checkDataStatus(biography);
    }
}
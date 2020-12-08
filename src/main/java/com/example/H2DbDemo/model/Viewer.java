package com.example.H2DbDemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Viewer")
public class Viewer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nickname;
  @ManyToMany
  @JoinTable(
      name = "followed_streams",
      joinColumns = @JoinColumn(name = "viewer_id"),
      inverseJoinColumns = @JoinColumn(name = "stream_id")
)
  private List<Stream> followedStreams = new ArrayList<>();

  public Viewer(String nickname) {
      this.nickname = nickname;
  }

  public void followStream(Stream stream){
      followedStreams.add(stream);
  }
}

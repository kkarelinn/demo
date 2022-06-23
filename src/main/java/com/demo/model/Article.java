package com.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "Articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "color")
    private Color color;

@JsonBackReference
@ManyToOne (optional=false, cascade=CascadeType.ALL)
@JoinColumn (name="user_id")
    private User user;

    public Article(String text, Color color, User user) {
        this.text = text;
        this.color = color;
        this.user = user;
    }

    @Override
    public String toString() {
        return "\nArticle{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", color=" + color +
                ", userId=" + (user==null? 0: user.getId()) +
                '}';
    }
}

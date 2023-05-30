package hibernate_many_to_many.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinTable(name = "child_section", // просто залупа, которая говорит, что я Join Table ссылаюсь на @Table
            joinColumns = @JoinColumn(name = "section_id"), // связь с section ИМЕННО ССЫЛКА НА НЕГо. na PK source
            // таблицы
            inverseJoinColumns = @JoinColumn(name = "child_id")) // эта залупа сошлется на поле снизу. na PK target
    // таблицы
    private List<Child> childList;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildList() {
        return childList;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", childList=" + childList +
                '}';
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public void addChildToSection(Child child) {
        if (childList == null) {
            childList = new ArrayList<>();
        }
        childList.add(child);
    }

}

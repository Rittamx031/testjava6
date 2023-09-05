package thatdz.java6.java6lab1.entity;

public class Slogan {
    public String text;
    public int count = 1;

    public int GetCount() {
        return count;
    }

    public void increaCount() {
        this.count = count+1;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Slogan(String text, int count) {
        this.text = text;
        this.count = count;
    }

    public Slogan(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Slogan other = (Slogan) obj;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.text + "  " + this.count;
    }
}

package com.example.hi.retro;

public class ActorBean
{
    private Actors[] actors;

    public Actors[] getActors ()
    {
        return actors;
    }

    public void setActors (Actors[] actors)
    {
        this.actors = actors;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [actors = "+actors+"]";
    }
}
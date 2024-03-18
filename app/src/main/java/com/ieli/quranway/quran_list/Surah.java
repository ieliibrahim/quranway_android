package com.ieli.quranway.quran_list;

import java.util.Objects;

public class Surah {
    private String surahName;
    private int surahNumber;
    private int pageNumber;
    private int ayatCount;

    public String getSurahName() {
        return surahName;
    }

    public void setSurahName(String surahName) {
        this.surahName = surahName;
    }

    public int getSurahNumber() {
        return surahNumber;
    }

    public void setSurahNumber(int surahNumber) {
        this.surahNumber = surahNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getAyatCount() {
        return ayatCount;
    }

    public void setAyatCount(int ayatCount) {
        this.ayatCount = ayatCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Surah surah = (Surah) o;
        return surahNumber == surah.surahNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(surahNumber);
    }
}
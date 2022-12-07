// See https://aka.ms/new-console-template for more information

Console.WriteLine("Part 1: " + Main.Part1());
Console.WriteLine("Part 2: " + Main.Part2());

public static class Main
{
    public static int Part1()
    {
        int count = 0;
        var firstPart = GetDataFromFile(0);
        var secondPart = GetDataFromFile(1);

        for(int i = 0; i < firstPart.Count; i++)
        {
            var firstSeq = CreateSequence(firstPart[i].Split('-'));
            var secondSeq = CreateSequence(secondPart[i].Split('-'));
            var allOffirstSeqIsInSecondSeq = firstSeq.Intersect(secondSeq).Count() == firstSeq.Count();
            var allOffsecondSeqIsInFirstSeq = secondSeq.Intersect(firstSeq).Count() == secondSeq.Count();

            if(allOffirstSeqIsInSecondSeq || allOffsecondSeqIsInFirstSeq)
            {
                count++;
            }
        }

        return count;
    }

    public static int Part2()
    {
        int count = 0;
        var firstPart = GetDataFromFile(0);
        var secondPart = GetDataFromFile(1);

        for (int i = 0; i < firstPart.Count; i++)
        {
            var firstSeq = CreateSequence(firstPart[i].Split('-'));
            var secondSeq = CreateSequence(secondPart[i].Split('-'));
            var allOffirstSeqIsInSecondSeq = firstSeq.Intersect(secondSeq);

            if (allOffirstSeqIsInSecondSeq.Count() != 0)
            {
                count++;
            }

        }

        return count;
    }

    public static List<int> CreateSequence(string[] range)
    {
        int start = int.Parse(range[0]);
        int end = int.Parse(range[1]);
        var list = new List<int>();
        for(int i = start; i <= end; i++)
        {
            list.Add(i);
        }

        return list;
    }

    public static List<string> GetDataFromFile(int type)
    {
        List<string> list = new List<string>();
        string[] lines = File.ReadAllLines(@"C:\Users\janmr\Desktop\Advent Of Code 2022\Day4\Day4\input.txt");

        foreach (string line in lines)
        {
            list.Add(line.Split(',')[type]);
        }

        return list;
    }
}

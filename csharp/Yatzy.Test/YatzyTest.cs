using System.Collections.Generic;
using ApprovalTests;
using ApprovalTests.Reporters;
using Xunit;

namespace Yatzy.Test
{
    [UseReporter(typeof(DiffReporter))]
    public class YatzyTest
    {
        [Fact]
        public void TODO()
        {
            Approvals.VerifyAll(new List<int> { 1, 2 }, t => $"{t} => {t}");
        }
    }
}
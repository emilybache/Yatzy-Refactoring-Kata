const { beforeAll, describe, it } = require("@jest/globals");

const { verifyAll } = require("approvals/lib/Providers/Jest/JestApprovals");
const { configure } = require("approvals/lib/config");
const { JestReporter } = require("approvals/lib/Providers/Jest/JestReporter");

const Yatzy = require("../lib/Yatzy");

describe("Yatzy", () => {
    beforeAll(() => {
        configure({
            reporters: [new JestReporter()],
        });
    });

    it('TODO', function () {
        verifyAll('throws', [1,2], (t) => JSON.stringify({ throw: t }))
    });
});

import { beforeAll, describe, it } from "@jest/globals";

import {verifyAll} from "approvals/lib/Providers/Jest/JestApprovals";
import {configure} from "approvals/lib/config";
import {JestReporter} from "approvals/lib/Providers/Jest/JestReporter";

import Yatzy from '../src/Yatzy';

describe('Yatzy', () => {
  beforeAll(() => {
    configure({
      reporters: [new JestReporter()],
    });
  });

  it('TODO', function () {
    verifyAll('throws', [1,2], (t: number) => JSON.stringify({ throw: t }))
  });
})
